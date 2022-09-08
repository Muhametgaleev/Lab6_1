package common.commands;

import common.supplier.Supply;

public interface Command {
    void execute(Supply s);
    void declare(Supply s);

    String getName();
}
