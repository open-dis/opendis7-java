# PDU Log Files

This directory holds temporary PDU log files which are considered transient and
may be deleted at any time!

Be sure to save your work, when appropriate, by copying log files of interest to
a different directory (and likely renaming them as well, for clarity).

To clean out old PDU log files, simply run [build.xml](build.xml) target `clean.all.log.files`

Each time you run a DIS simulation and a PduRecorder is listening, another
log file is created.  File names are numbered sequentially and uniquely, so that 
important PDU log captures can later be copied and saved to where they are needed.

[PduCaptureLogExample.dislog](PduCaptureLogExample.dislog) shows an example log file.

Note that the PDU log files are very tolerant of inline comments starting with
a # character, so you can document success/failure and TODO issues there as well.

<!-- https://github.com/open-dis/opendis7-java/tree/master/pduLogs/README.md -->
