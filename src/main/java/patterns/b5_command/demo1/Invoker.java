package patterns.b5_command.demo1;


public class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action() {
        this.command.execute();
    }

}

