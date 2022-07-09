package com.avtopark.Controller.Commands;

public enum ECommand {
    home(new Home()),
    login(new Login()),
    CommandLogin(new CommandLogin()),
    LogOut(new CommandLogOut()),
    profile(new CommandProfile()),
    employments(new CommandEmployment()),
    addEmployment(new CommandAddEmployment()),
    deleteEmployment(new CommandDeleteEmployment()),
    freeUsers(new CommandFreeUsers()),
    freeBuses(new CommandFreeBuses()),
    freeRoutes(new CommandFreeRoutes())
    ;

    private final ICommand command;
    ECommand(ICommand command){
        this.command = command;
    }
    public ICommand getCommand() {
        return command;
    }

}
