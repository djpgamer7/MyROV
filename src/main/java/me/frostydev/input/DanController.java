package me.frostydev.input;

import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;

public class DanController {

    /**Initializaton of controller variables in the public scope**/
    Controller[] myControllers;
    Controller stick = null;
    Controller keyboard = null;
    Controller.Type neededType;

    /**Constructor**/
    public DanController(Controller.Type contType) {
        myControllers = ControllerEnvironment.getDefaultEnvironment().getControllers();
        Controller requestedObject;

        if(contType == Controller.Type.KEYBOARD) {
            neededType = Controller.Type.KEYBOARD;
        }

        if(contType == Controller.Type.STICK) {
            neededType = Controller.Type.STICK;
        }

        /**Loop until joystick object is found**/
        for(int i=0; i < myControllers.length && stick == null || keyboard == null; i++) {
            Controller.Type controllerType = myControllers[i].getType();

            /**Joystick object has been found!**/
            if(controllerType == neededType) {
                if(neededType == Controller.Type.KEYBOARD) {
                    keyboard = myControllers[i];
                } else if(neededType == Controller.Type.STICK) {
                    stick = myControllers[i];
                }
            }
        }
    }

    public Controller[] getControllers() {
        return myControllers;
    }

    public Controller getStick() {
        return stick;
    }

    public Controller getKeyboard() {
        return keyboard;
    }

    public void getYAxis() {
        while (true) {
            stick.poll();

            Component[] components = stick.getComponents();
        }
    }


}
