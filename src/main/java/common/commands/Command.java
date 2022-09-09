package common.commands;

import common.supplier.Supply;

import java.net.SocketException;

public interface Command {
    void execute(Supply s);
    void declare(Supply s) throws SocketException;

    String getName();
}
