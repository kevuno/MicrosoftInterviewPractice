""" Interview Cake question No. 23 Does this Linked List have a loop?"""

# A node class implementation
class LinkedListNode:
    def __init__(self, value):
        self.value = value
        self.next  = None

""" 
    Peforms a check through the list with two pointers, one moves one node at a time, the other one two at a time,
    if they ever cross the same value, it means that the fast pointer 'catched up' to the slow one, meaning that the linked list 
    loops
"""
def hasLoop(linkedListNode):
    runnerFast = linkedListNode.next.next
    runnerSlow = linkedListNode.next

    runnerSlowGoes = False
    while(runnerFast.value != runnerSlow.value):
        # print("Slow at ",runnerSlow.value)
        # print("Fast at ",runnerFast.value)
        if(runnerFast.next == None):
            print("List is none looping")
            break
        if(runnerSlowGoes):
            runnerSlow = runnerSlow.next
            runnerSlowGoes = False
        else:
            runnerSlowGoes = True
        runnerFast = runnerFast.next
    if(runnerFast.value == runnerSlow.value):
        print("List had a loop")


#Creating a linkedlist with a loop to the first node
def test1():
    list = LinkedListNode(1)
    list.next = LinkedListNode(2)
    list.next.next = LinkedListNode(3)
    list.next.next.next = list
    hasLoop(list)
#Creating a linkedlist with no loop
test1()
def test2():
    list = LinkedListNode(1)
    list.next = LinkedListNode(2)
    list.next.next = LinkedListNode(3)
    hasLoop(list)    
test2()

#Creating a linkedlist with a loop to the second node
def test3():
    list = LinkedListNode(1)
    list.next = LinkedListNode(2)
    list.next.next = LinkedListNode(3)
    list.next.next.next = list.next
    hasLoop(list)    
test3()

#Creating a linkedlist with a loop to the final node
def test4():
    list = LinkedListNode(1)
    list.next = LinkedListNode(2)
    list.next.next = LinkedListNode(3)
    list.next.next.next = list.next.next
    hasLoop(list)    
test4()