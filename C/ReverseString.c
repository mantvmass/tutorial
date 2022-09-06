#include <stdio.h>
#include <stdlib.h>



struct Node {
    char data;
    struct Node* next;
};


static void reverse(struct Node** head_ref);
void push(struct Node** head_ref, int new_data);
void printList(struct Node* head);



/* Driver code*/
int main() {
    /* Start with the empty list */
    struct Node* head = NULL;
    int end, count = 0;
    char str[500];

    printf("enter charecter: ");
    scanf("%[^\n]", str);

    while (str[count] != '\0'){ count++; }
    end = count - 1;
    
    for (int i = 0; i < count; i++, end--) { push(&head, str[end]); }

    printf("Link list before\n");
    printList(head);
    printf("\nReverse Link list After\n");
    reverse(&head);
    printList(head);
    getchar();
    return 0;
}



static void reverse(struct Node** head_ref){
    struct Node* prev = NULL;
    struct Node* current = *head_ref;
    struct Node* next = NULL;
    while (current != NULL) {
        next = current->next;
        current->next = prev;
        prev = current;
        current = next;
    }
    *head_ref = prev;
}


void push(struct Node** head_ref, int new_data){
    struct Node* new_node = (struct Node*)malloc(sizeof(struct Node));
    new_node->data = new_data;
    new_node->next = (*head_ref);
    (*head_ref) = new_node;
}


void printList(struct Node* head){
    struct Node* temp = head;
    while (temp != NULL) {
        printf("%c  ", temp->data);
        temp = temp->next;
    }
}
