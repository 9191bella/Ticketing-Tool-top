public class Testklasse {
    public static void main(String[] args) {
        Date date1 = new Date();
        Date date2 = new Date();
        Date date3 = new Date();
        Date date4 = new Date();
        date1.init(1, 1, 2001);
        date2.init(24, 12, 2002);
        date3.init(15, 6, 1993);
        date4.init(); // aktuelles Datum

        System.out.println("Date1: " + date1);
        System.out.println("Date2: " + date2);
        System.out.println("Date3: " + date3);
        System.out.println("Date4: " + date4);  
        System.out.println("Date1 after Date2? " + date1.after(date2));
        System.out.println("Date1 before Date2? " + date1.before(date2));
        System.out.println("Date1 after Date3? " + date1.after(date3));
        System.out.println("Date1 before Date3? " + date1.before(date3));

        Category ticketCategory1 = new Category(11, "Software", "Software related issues");
        Category ticketCategory2 = new Category(12, "Hardware", "Hardware related issues");
        Category ticketCategory3 = new Category(13, "Network", "Network related issues");
        Category ticketCategory4 = new Category(14, "Testing", "Testing related issues");
        Category customerCategory1 = new Category(21, "VIP", "VIP customers");
        Category customerCategory2 = new Category(22, "Regular", "Regular customers");
        Category customerCategory3 = new Category(23, "New", "New customers");
        Category customerCategory4 = new Category(24, "Test", "Testing customers");
        Category agentCategory1 = new Category(31, "IT Support", "IT Support agents");  
        Category agentCategory2 = new Category(32, "Customer Service", "Customer Service agents");
        Category agentCategory3 = new Category(33, "Sales", "Sales agents");
        Category agentCategory4 = new Category(34, "Testing", "Testing agents");

        System.out.println(ticketCategory1.toString());
        System.out.println(customerCategory1.toString());
        System.out.println(agentCategory1.toString());

        Agent agent1 = new Agent(101, "Max Mustermann", "max.mustermann@example.com", "Vertrieb", "Sales Manager", agentCategory1, 2);
        Agent agent2 = new Agent(102, "Erika Musterfrau", "erika.musterfrau@example.com", "Vertrieb", "Sales Associate", agentCategory2, 1);
        
        System.out.println(agent1.toString());
        System.out.println(agent2.toString());

        Customer customer1 = new Customer(201, "John Doe", "john.doe@example.com", customerCategory1);
        Customer customer2 = new Customer(202, "Jane Smith", "jane.smith@example.com", customerCategory2);
        Customer customer3 = new Customer(203, "Bob Johnson", "bob.johnson@example.com", customerCategory3);
        Customer customer4 = new Customer(204, "Alice Williams", "alice.williams@example.com", customerCategory4);

        System.out.println(customer1.toString());
        System.out.println(customer2.toString());
        System.out.println(customer3.toString());
        System.out.println(customer4.toString());

        Ticket ticket1 = new Ticket(111, "Test Ticket", "This is our very first test ticket", ticketCategory4, Status.OPEN, date1, date1, date2, customer1, null);
        Ticket ticket2 = new Ticket(112, "Another Test Ticket", "This is our second test ticket", ticketCategory4, Status.OPEN, date1, date1, date3, customer2, agent2);
        Ticket ticket3 = new Ticket(113, "Third Test Ticket", "This is our third test ticket", ticketCategory1, Status.OPEN, date1, date1, date4, customer3, agent1);

        System.out.println(ticket1.toString());
        System.out.println(ticket2.toString());
        System.out.println(ticket3.toString());

        Comment comment1 = new Comment (1001, "This is a comment on a ticket", ticket1, customer1, date1);
        Comment comment2 = new Comment (1002, "This is the answer to the comment", ticket1, agent1, date2);
        Comment comment3 = new Comment (1003, "This is the comment to another ticket", ticket2, customer2, date4);

        System.out.println(comment1.toString());
        System.out.println(comment2.toString());
        System.out.println(comment3.toString());

        TicketAdministration ticketAdmin = new TicketAdministration();
        ticketAdmin.addTicket(ticket1);
        ticketAdmin.addTicket(ticket2);
        ticketAdmin.addTicket(ticket3);
        ticketAdmin.addAgent(agent1);
        ticketAdmin.addAgent(agent2);
        ticketAdmin.addCustomer(customer1);
        ticketAdmin.addCustomer(customer2);
        ticketAdmin.addCustomer(customer3);
        ticketAdmin.addCustomer(customer4);
        ticketAdmin.addCategory(ticketCategory1);
        ticketAdmin.addCategory(ticketCategory2);
        ticketAdmin.addCategory(ticketCategory3);
        ticketAdmin.addCategory(ticketCategory4);
        ticketAdmin.addCategory(customerCategory1);
        ticketAdmin.addCategory(customerCategory2);
        ticketAdmin.addCategory(customerCategory3);
        ticketAdmin.addCategory(customerCategory4);
        ticketAdmin.addCategory(agentCategory1);
        ticketAdmin.addCategory(agentCategory2);
        ticketAdmin.addCategory(agentCategory3);
        ticketAdmin.addCategory(agentCategory4);
        
        System.out.println(ticketAdmin.toString());

        // Verwaltungslisten mit den am Ticket beteiligten Personen füllen
        AgentList agentList = new AgentList();
        agentList.addAgent(agent1);
        agentList.addAgent(agent2);

        CustomerList customerList = new CustomerList();
        customerList.addCustomer(customer1);
        customerList.addCustomer(customer2);
        customerList.addCustomer(customer3);

        // ===== 3 konkrete Überprüfungs-Befehle für die 3 Tickets =====

        // Befehl 1: Ersteller (Customer) von ticket1 in der CustomerList nachschlagen
        System.out.println("Ticket 1 - Ersteller in CustomerList gefunden: "
                + customerList.findById(ticket1.getCreatedBy().getId()));

        // Befehl 2: Bearbeiter (Agent) von ticket2 in der AgentList nachschlagen
        System.out.println("Ticket 2 - Bearbeiter in AgentList gefunden: "
                + agentList.findById(ticket2.getResolvedBy().getId()));

        // Befehl 3: Ersteller von ticket3 per Namenssuche in der CustomerList finden
        System.out.println("Ticket 3 - Ersteller per Namenssuche: "
                + customerList.findByName(ticket3.getCreatedBy().getName()));
    }
}