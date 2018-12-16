package ds.linkedlist

import scala.io.StdIn.readInt

class Node {
  var key: Option[Int] = None
  var next: Option[Node] = None
}

object LinkedList extends App{
  var start = new Node
  create()
  traverse(start)
  def create() = {
    print("enter the elments in the LL: ")
    val len = readInt
    (1 to len) foreach (item => {
      println("enter node key: ")
      insert(readInt)
    })
  }

  def traverse(temp: Node) = {
    var start = temp
    while (start.key.isDefined) {

      print(s"${start.key.get} -> ")
     // if(start.next.isDefined)
      start = start.next.get

    }
  }

  def insert(key: Int) = {
    var temp = start
    if (start.key.isEmpty) start.key = Some(key)
    else {
      while (temp.next.isDefined) {
        temp = temp.next.get
      }
      val node = new Node
      node.key = Some(key)
      temp.next = Some(node)
    }

  }
}

/*
*
*
t != null && i <= n) {
            refPointer = refPointer.next;
            i++;
        }
        if (i < n) {
            System.out.println("ll is too short, number of elements < " + n);
            return null;
        }
        while (refPointer.next != null) {
            refPointer = refPointer.next;
            pointer = pointer.next;
        }
        System.out.println(n + "th element from the end is " + pointer.next.data);
        return pointer.next;

    }

    public LLNode findNthElementFromTheEndNew(LLNode start, int n) {
        nullCheck(start);
        LLNode temp = new LLNode();
        temp.next = start.next;

        for (int i = 0; i < (n - 1); i++) {
            if (temp.next == null) {
                System.out.println("LL too short");
                throw new IndexOutOfBoundsException("LL too short");
            } else
                temp = temp.next;
        }

        while (temp != null) {
            start = start.next;
            temp = temp.next;
        }
        return temp;

    }

    public void nullCheck(LLNode start) {
        if (start.next == null) {
            System.out.println("ll is empty");
            return;
        }
    }

    public void deleteTheLL(LLNode start) {
        System.out.println(
                "In Java, automatic garbage collection happens, so deleting a linked list is easy. We just need to change head to null.");
        start.setNext(null);

    }

    public int findNumberOfTimesANodeValueRepeatsRecursively(LLNode start, int number) {

        int counter = 0;
        LLNode current = new LLNode(start.next);
        nullCheck(start);
        while (current.next != null) {
            if (current.next.data == number) {
                counter++;
                findNumberOfTimesANodeValueRepeatsRecursively(current.next, number);

            }
            current = current.next;
        }
        return counter;
    }

    public int findNumberOfTimesANodeValueRepeatsRecursivelyNew(LLNode node, int number) {
        ;
        if(node==null) return 0;
        if(node.data==number) return 1+findNumberOfTimesANodeValueRepeatsRecursivelyNew(node.next, number);
        else return findNumberOfTimesANodeValueRepeatsRecursivelyNew(node.next, number);

    }
    public LLNode reverseLL(LLNode start) {
        // For first node, previousNode will be null
        LLNode current = new LLNode(start.next);
        // we could also use start in place of current
        LLNode previousNode = null;
        LLNode nextNode;
        while (current != null) {
            // save state of next node, don't loose it's track
            // as we we change link of current.next
            nextNode = current.next;

            // reversing the link of currentNode
            // notice here we are not setting nextNode.next=current,
            // we do 1 step at a time.
            current.setNext(previousNode);
            // moving currentNode and previousNode by 1 node
            previousNode = current;
            current = nextNode;
        }
        traverse(previousNode);
        return previousNode;
    }

    public LLNode reverseLLNew(LLNode start) {
        LLNode current = new LLNode();
        current = start.next;
        LLNode previousNode, nextNode;
        previousNode = null;
        while (current != null) {
            nextNode = current.next;
            current.next = previousNode;
            previousNode = current;
            current = nextNode;

            // while processing the last node
            // current node will be the last node
            // next node will point to null
            // previousNode willl be come actual last node
        }
        // return previousNode;

        LLNode tail = new LLNode();
        tail.next = previousNode;
        traverse(tail);
        return tail;
    }

    public LLNode detectALoopInLL(LLNode start) {
        LLNode scanner = new LLNode(start);
        LLNode scanner2x = new LLNode(start);
        while (scanner.next != null && scanner2x.next != null) {
            scanner = scanner.next;
            scanner2x = scanner2x.next.next;
            if (scanner.next == scanner2x.next) {
                System.out.println("loop detected in ll");
                // return the node at which the loop is found
                return scanner.next;
            }

        }
        System.out.println("there is no loop ");
        return null;
    }

    public LLNode createCircularLL() {
        LLNode start = new LLNode();
        LLNode current = new LLNode();
        LLNode firstNode = new LLNode();
        current = start;
        System.out.println("Creating LL. Enter number of nodes");
        int numberOfNodes = scanner.nextInt();

        for (int i = 0; i < numberOfNodes; i++) {

            System.out.println("enter data value");
            int data = scanner.nextInt();
            LLNode node = new LLNode(data);
            current.setNext(node);
            if (i == 0) {
                firstNode = node;
            }
            current = current.next;
        }

        current.setNext(firstNode);
        return start;

    }

    public void checkIfTwoLLsIntersect(LLNode startFirst, LLNode startSecond) {

		/*
		 * here we have to parts ... 1)Given two singly linked list, find if they are
		 * intersecting. Do this in single iteration. a) traverse list1 and find the
		 * last element b) traverse list2 and find the last element c) check if last
		 * element of list1 == last element of list2 , if equal intersecting else not
		 * here we have parsed the list only once :-)
		 */
        LLNode lastNodeOfFirstLL, lastNodeOfSecondLL;
        lastNodeOfFirstLL = getLastNode(startFirst);
        lastNodeOfSecondLL = getLastNode(startSecond);
        if (lastNodeOfFirstLL == lastNodeOfSecondLL) {
            System.out.println("the two LLs intersect/have last node in common, the common node has data value as "
                    + lastNodeOfFirstLL.data);
        } else {
            System.out.println("the two LLs don't intersect");
        }

    }

    private LLNode getLastNode(LLNode start) {
        LLNode current = new LLNode(start);
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    public LLNode checkIfTwoLLsIntersectUsingASet(LLNode firstLL, LLNode secondLL) {

        LLNode startNodeOfFirstLL = new LLNode(firstLL);
        LLNode startNodeOfSecondLL = new LLNode(secondLL);
        Set<LLNode> set = new HashSet<>();
        boolean intersect = false;
        // add all node addresses of firstll to a set
        while (startNodeOfFirstLL != null) {
            set.add(startNodeOfFirstLL.next);
            startNodeOfFirstLL = startNodeOfFirstLL.next;
        }
        System.out.println(set);
        // do the same with second ll if a duplicate is found there is
        // intersection at that point
        while (startNodeOfSecondLL != null) {
            intersect = set.add(startNodeOfSecondLL.next);
            if (!intersect) {
                System.out.println("the two LLs intersect at Node with value " + startNodeOfSecondLL.data
                        + "returning the intersecting node");
                return startNodeOfFirstLL;
            }
            startNodeOfSecondLL = startNodeOfSecondLL.next;
        }
        System.out.println("the two LLs don't intersect, returning null");
        return null;
    }

    public void traverseCircularLL(LLNode startNodeOfCircularLL) {
        LLNode firstNodeOfCircularLL = startNodeOfCircularLL;
        LLNode current = new LLNode(startNodeOfCircularLL.next);
        System.out.println("---------------------------------------------------------");
        do {
            current = current.next;
            System.out.print(current.data + "    ");

        } while (current.next != firstNodeOfCircularLL.next);
        System.out.println();
        System.out.println("---------------------------------------------------------");
    }

    public void test(LLNode start){
        LLNode one =start;
        for(int i=0;i<3;i++){
            one=one.next;
        }
        System.out.println("one "+one.data+" start "+start.data);
                //LLNode two=start
    }

    public void deleteDups(LLNode node) {
        Set<Integer> set = new HashSet<>();
        LLNode previous = null;
        // no NPE as first element is never a dup and in the next iteration previous
        // will a assigned a val for sure.

        while (node != null) {
            if (set.contains(node.data)) {
                previous.next = node.next;
            } else {
                set.add(node.data);
                previous = node;
            }
            node = node.next;
        }
    }

    public LLNode addNumbers(LLNode l1, LLNode l2) {
        LLNode start = new LLNode();
        LLNode l = start;
        int carry = 0, sum, result;
        while (l1 != null) {
            result = l1.data + l2.data + carry;
            sum = result % 10;
            carry = result / 10;
            l = new LLNode(sum);
            l = l.next;
        }
        if (carry != 0) {
            l = new LLNode(carry);
        }
        return start;
    }

}

* */
