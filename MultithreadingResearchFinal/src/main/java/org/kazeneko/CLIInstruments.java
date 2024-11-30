package org.kazeneko;

import org.apache.commons.cli.*;

public class CLIInstruments {
    public Options getOptions() {
        Options options = new Options();
        // writing to the file
        Option writeOption = new Option("w","write",true,
                "Enable writing the task to the file. Requires explicitly specifying the filepath.");
        writeOption.setRequired(false);
        options.addOption(writeOption);
        // reading form the file
        Option readOption = new Option("r","read",true,
                "Enable reading a task from the file. Requires explicitly specifying the filepath.");
        readOption.setRequired(false);
        options.addOption(readOption);
        // n variable
        Option nOption = new Option("n", true,
                "Defines the length of the task file. It must be an integer in the range from 1 to 10^9");
        nOption.setRequired(true);
        options.addOption(nOption);
        // parallel computing
        Option parallelOption = new Option("p","parallel",true,
                "Enable the parallel computing mode. If this parameter is omitted, the calculations are " +
                        "performed sequentially. The number of threads must be specified explicitly. It must be an" +
                        " integer in the range from 2 to 100.");
        parallelOption.setRequired(false);
        options.addOption(parallelOption);
        // math operation
        Option operationOption = new Option("o", "operation", true,
                "Defines whether multiplication, exponentiation, factorialisation or getting " +
                        "Fibonaccinumber will be used for computations. To select the math operation to" +
                        " be used pass the value MULT, EXP, FACT or FIB respectively.");
        operationOption.setRequired(true);
        options.addOption(operationOption);
        // k variable
        Option kOption = new Option("k",true,
                "Defines the coefficient k that is required for multiplication and exponentiation");
        kOption.setRequired(false);
        options.addOption(kOption);
        return options;
    }
    public CommandLine getCommandLine(Options options, String[] args) throws ParseException {
        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        try {
            return parser.parse(options, args);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            formatter.printHelp("utility-name", options);
            throw new ParseException(e.getMessage());
        }
    }
}
