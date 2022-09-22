class Foo(object):

    def __init__(self, auther) -> None:
        self.auther = auther

    def Hello(self):
        print(self.auther + " say: Hello")

    def Ok(self):
        print(self.auther + " say: Ok")

    def Yes(self):
        print(self.auther + " say: Yes")

    def No(self):
        print(self.auther + " say: No")


#Ex 1
classes = Foo("Phumin") # call all func in class
public_method_names = [method for method in dir(classes) if callable(getattr(classes, method)) if not method.startswith('_')]  # 'private' methods start from _
# print(public_method_names) # show data
methods = []
for method in public_method_names:
    # getattr(classes, method)()  # call func // if no use list
    methods.append(getattr(classes, method)) # add to list
# print(methods) # show data
for method in methods:
    method()  # call func / if use list



#Ex 2
classes = Foo("Phumin") # call all func in class
methods = []
for method, _ in Foo.__dict__.items():
    # print(_) # show data
    if not method.startswith('_'):
        # getattr(classes, method)()  # call func // if no use list
        methods.append(getattr(classes, method)) # add to list
# print(methods) # show data
for method in methods:
    method()  # call func / if use list
