# PDU Log Files

This directory holds temporary PDU log files which may be deleted at any time!

Each time you run a DIS simulation and a PduRecorder is listening, another
log file is created.  File names are numbered sequentially and uniquely, so that 
important PDU log captures can later be copied and saved to where they are needed.

[ExamplePduCaptureLog.dislog](ExamplePduCaptureLog.dislog) shows an example log file.

Be sure to save your work, when appropriate, by copying log files of interest to
the corresponding homework or project directory (and likely renaming as well).

Note that the PDU log files are very tolerant of inline comments starting with
a # character, so you can document success/failure and TODO issues there as well.

To clean out old log files, simply run [build.xml](build.xml) target `clean.all.log.files`
