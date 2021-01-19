
package doublelist;

/**
 *
 * @author luish
 */
public class DoubleList {
    private Node top;
    private Node last;
    
    public DoubleList(){
        setTop(null);
        setLast(null);
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    public Node getTop() {
        return top;
    }

    public void setTop(Node top) {
        this.top = top;
    }
    
    public String showList(){
        String out= "List: ";
        Node temp = getTop();
       
        while(temp!=null){
            out += temp;
            temp = temp.getNext();
        }
        out += "null";
        return out;
    }
    
    public boolean isEmpty(){
        if(getTop()==null && getLast()==null){
            return true;
        }else{
        return false;
     }
    }
    
    public void instertLast(String name){
        Node newNode = new Node();
        newNode.setName(name);
        
        if(isEmpty()){
            setTop(newNode);
            setLast(newNode);
        }else{
            getLast().setNext(newNode);
            newNode.setPrevious(last);
            setLast(newNode);
        }
        
    }
    
     public void instertTop(String name){
        Node newNode = new Node();
        newNode.setName(name);
        
        if(isEmpty()){
            setTop(newNode);
            setLast(newNode);
        }else{
            newNode.setNext(getTop());
            getTop().setPrevious(newNode);
            setTop(newNode);
        }
    }
     
     public Node search(String find){
       return (recursiveSearch(find, null));
   }
     
   public Node recursiveSearch(String find, Node temp){
        if(temp.getName().equals(find)){
            return temp;
        }else{
            return recursiveSearch(find, temp.getNext());
        }
   }   
    
    public boolean insertBetween(String find, String name){
        Node newNode = new Node();
        newNode.setName(name);
        
        if(isEmpty()){
            setTop(newNode);
            setLast(newNode);
            return true;
        }else{
            Node actually = search(find);
            if(actually!=null){
                Node temp = actually.getNext();
                actually.setNext(newNode);
                newNode.setNext(temp);
                return true;
            }else{
                System.out.println("No se encuentra la posicion solicitada");
                return false;
            }
        }
    }
}
