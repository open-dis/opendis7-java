
<h2>DIS Library Validation</h2>
Reference logs for unit testing are maintained here.

When new code is added to the Open DIS libraries, it is important to ensure correctness of produced network objects (PDUs) with those produced by previous versions.  This also implies correctness per the IEEE and SISO specifications, so the initial basis for comparison must be manually (or otherwise) confirmed to match.

Validation within this library is done through several classes in the `edu.nps.moves.dis7.utilities.stream` package:

1. `PduRecorder` -- accepts byte arrays read from the net and appends them to a log file.  
2. `PduPlayer`-- reads byte arrays from a log file and sends them out over the net.
