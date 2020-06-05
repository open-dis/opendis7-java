
<h2>DIS Library Validation</h2>
When new code is added to the Open DIS libraries, it is important to ensure correctness of produced network objects (PDUs) with those produced by previous versions.  This also implies correctness per the IEEE and SISO specifications, so the initial basis for comparison must be manually (or otherwise) confirmed to match.

Validation within this library is done through several classes in the `edu.nps.moves.dis7.utilities.stream` package:

1. `PduRecorder` -- accepts byte arrays read from the net and appends them to a log file.  
2. `PduPlayer`-- reads byte arrays from a log file and sends them out over the net.
3. `LogCompare` -- compares log files and reports differences to the console.
4. `ValidationPdusMakerV1` -- generates and records the "official" sequence of Pdus used to validate a library.

To create a log file using the current library, run the main() method in`ValidationPdusMakerV1`.  You may pass it a directory name and a file name.  If run without arguments, the defaults are `./validatorOut` and `validationLog.txt`.

Once there are 2 or more log files to compare, pass the paths to both files to `LogCompare`.
