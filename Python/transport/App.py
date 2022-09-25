import json
import os
from sys import exit
from pick import pick


############################################################
# Process
############################################################
def QueryStation(station_id = None):
    with open("database/bus.json", encoding="utf-8") as data:
        result = json.loads(data.read())
    if station_id != None:
        for i in result['station']:
            if station_id == i['data']['station_id']: return i
        return False
    return result


def QueryToStation(station_id):
    datas = []
    result_query = QueryStation(station_id)
    if result_query['data']['to'] == None: return False
    for i in result_query['data']['to']:
        data = QueryStation(i)
        if data != False: datas.append(data)
    return datas


def QueryTicket():
    with open("database/ticket.json", encoding="utf-8") as data:
        result = json.loads(data.read())
    return result


def ConfirmTicket(seat, **kargw): # update data
    starcar, km = QueryToStation(kargw["from_t"]), 0
    for i in starcar:
        if i["data"]["station_id"] == kargw['to_t']: break
        km += i["data"]["park"][1]
    pointstar = QueryStation(kargw["from_t"])
    km += pointstar["data"]["park"][1]
    price = km * 1 # km * thb
    # add data to ticket.json
    ticket = QueryTicket()
    isdata = {
        "ticket_id": 1,
        "fullname": "Phumin Maliwan",
        "price": price,
        "detail": {
            "seat": seat,
            "from": kargw['from_t'],
            "to": kargw['to_t'],
            "km": km
        }
    }
    ticket["data"].append(isdata)
    status = None
    try:
        with open("database/ticket.json", "w") as data:
            json.dump(ticket, data, indent=4)
        status = True
    except Exception as Er: status = Er
    if status != None and status == True: return status
    else: return status
    

def CheckTicket(_from, _to): # call buy function / main algorithm
    seat = []
    blockdata, blocked = [], []
    for i in range(8): # gen seat 4x8 = 32 seat
        seat.append([ "A"+str(i+1), "B"+str(i+1), "C"+str(i+1), "D"+str(i+1) ])
    data = QueryTicket() 
    for i in data['data']: # add to blockdata
        if i['detail']['from'] == _from or _to == i['detail']['to']: # is if add to blocked
            blocked.append(i['detail']['seat'])
        array = []
        array.append(i['detail']['seat'])
        query = QueryStation(i['detail']['from'])
        for p in range(len(query['data']['to'])):
            if query['data']['to'][p] == i['detail']['to']:
                # array.append(query['data']['to'][p])
                break
            else:
                array.append(query['data']['to'][p])
        blockdata.append(array)
    for i in blockdata: # add to blocked
        if len(i) > 1:
            for o in range(1, len(i)):
                if _from == i[o] or _to == i[o]:
                    blocked.append(i[0])

    ######## input seat ########
    os.system("cls")
    print("Please select seat\n\033[41mWarning\033[0m: Red background = busy")
    style = []
    for se in seat:
        countstyle = []
        for i in se:
            if i in blocked: countstyle.append('\033[41m'+str(i)+'\033[0m')
            else: countstyle.append(i)
        style.append(countstyle)
    # show seat data
    print("-------------------------------------------------")
    print("from: " + str(QueryStation(_from)['data']['name']))
    print("to: " + str(QueryStation(_to)['data']['name']))
    print("-------------------------------------------------")
    for row in style:
        print(*row, sep="---")
    # input validate
    sw = None
    while sw != 0:
        selectseat = input("Enter seat: ")
        selist = []
        for se in seat:
            selist += se
        if selectseat in selist:
            sw = 0
        else: print("This seat is not available!")
    ######## end input seat ########

    ######## save seat ########
    if selectseat in blocked:
        return "Seat is busy!"
    return ConfirmTicket(selectseat, from_t = _from, to_t = _to)
    ######## end save seat ########



############################################################
# Sample Ui
############################################################
def BuyTicket():
    ####### menu select departure #######
    result_query_station = QueryStation()
    title = 'Please select a departure station:'
    options = []
    for i in result_query_station['station']: # add menu option
        if i['data']['to'] != None:
            options.append("[*] Station: " + str(i['data']['name']))
    option, _ = pick(options, title, indicator='=>', default_index=0)
    id_departure = None # use data
    for i in result_query_station['station']: # search id departure
        # if option.split(" ")[-1] == i['data']['name']:
        if option == "[*] Station: " + str(i['data']['name']):
            id_departure = i['data']['station_id'] # use data
            break
    ####### end menu select departure #######

    ####### menu select destination #######
    result_query_to_station = QueryToStation(id_departure) # query departure to destination
    title = 'Please select a destination station:'
    options = []
    for i in result_query_to_station:  # add menu option
        options.append("[*] Station: " + str(i['data']['name']))
    option, _ = pick(options, title, indicator='=>', default_index=0)
    id_destination = None # use data
    for i in result_query_station['station']: # search id destination
        # if option.split(" ")[-1] == i['data']['name']:
        if option == "[*] Station: " + str(i['data']['name']):
            id_destination = i['data']['station_id'] # use data
            break
    ####### end menu select destination #######

    ####### action ticket #######
    sw = None
    while sw != True:
        result = CheckTicket(id_departure, id_destination)
        if result == True:
            print("Buy Success")
            sw = True
            input("Enter to continue")
        else:
            print("Buy Failed: " + str(result))
            yn = input("Do it again? (y/n): ")
            if yn.upper() == "Y": pass
            else: sw = True
    ####### end action ticket #######
    


def ViewTicket():
    os.system("cls")
    print("=================== Ticket ======================")
    tickets = QueryTicket()
    for ticket in tickets["data"]:
        print("Fullname: " + str(ticket["fullname"]))
        print("Price: " + str(ticket["price"]))
        print("From: " + str(QueryStation(ticket["detail"]["from"])[
              "data"]["name"]) + " To: " + str(QueryStation(ticket["detail"]["to"])["data"]["name"]))
        print("Seat: " + str(ticket["detail"]["seat"]))
        print("=================== Ticket ======================")
    input("Enter to continue")



def Landing() -> int:
    title = 'Please select a place of origin:'
    options = ['[*] Buy Ticket', '[*] View Tictek', '[*] Exit']
    _, index = pick(options, title, indicator='=>', default_index=0)
    return index


############################################################
# Start
############################################################
def main() -> None:
    select = Landing()
    if select == 0: return BuyTicket()
    elif select == 1: return ViewTicket()
    else: return 0
    
if "__main__" == __name__:
    while True:
        if main() == 0: exit()
