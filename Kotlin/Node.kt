
class Node(val values: Any, var number: Int, var next: Node? = null, var prev: Node? = null) {
    

    init {
        println("Node created: $value")
    }

    
    fun setNext(node: Node?) {
        this.next = node
        node?.prev = this
    }

    
    fun setPrev(node: Node?) {
        this.prev = node
        node?.next = this
    }
}


class LinkedList {
    var head: Node? = null
    var tail: Node? = null

    
    fun add(value: Any, age: Int) {
        val newNode = Node(values, age)
        if (head == null) {
            head = newNode
            tail = newNode
        } else {
            tail?.setNext(newNode)
            tail = newNode
        }
    }

    
    fun display() {
        var currentNode = head
        while (currentNode != null) {
            print("${currentNode.value} -> ")
            currentNode = currentNode.next
        }
        println("null")
    }
}

fun main() {
    
    val linkedList = LinkedList()

    
    linkedList.add("First", 1)
    linkedList.add("Second", 2)
    linkedList.add("Third", 3)

    
    linkedList.display()
}
