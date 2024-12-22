package users;


import utils.Post;


/**
* @generated
*/
public abstract class Employee extends User {
    public Employee(String name, String lastName) {
        super(name, lastName);
    }

    public Employee() {
        super();
    }


    //                          Operations
    
    /**
    * @generated
    */
    public void sendMassage(String massage, Employee employee) {
        employee.getNotifications().add(new Post(massage, this));

    }




}
