# Android Calculator — SEG2105 Lab 1

This repository contains the Android calculator app created for SEG2105 Lab 1. The app implements a simple calculator that supports basic arithmetic operations.

## Lab goals

- Give exposure to Android Studio and the Android build system.
- Learn event-driven programming (button clicks -> events).
- Create user interfaces and wire UI elements to code.
- Practice basic troubleshooting and debugging.

## Lab objectives (required)

- Simple calculator app that supports:
	- addition (+)
	- subtraction (-)
	- multiplication (*)
	- division (/)
- Includes support for:
	- decimal numbers (e.g. 32.5)
	- clear (clears the display)
	- equal (performs calculation and displays result)

## Edge cases

When implementing the calculator, the following edge cases are handled:

- Pressing `=` when the screen is empty or cleared should not crash the app; show `0` or ignore.
- Negative numbers (e.g. `5 - 8 = -3`)
- Decimal operations (`5.3 + 1`) show `6.3` and not `6`.
- Integer operations (`3 + 6`) should display `9`, not `9.0` (format result appropriately).
- Division by zero should be handled properly (show `Error`)

## Required demo expressions (for submission video)

The following operations and edge cases are shown in the demo video (video is available in Brightspace submission):

- 1 + 1
- 2 * 3
- 4 / 5
- 10 - 3

https://github.com/user-attachments/assets/94791775-c7ea-472b-963f-2007c4bedcab


## Prerequisites:

- Java JDK 11 or newer
- Android Studio with Android SDK installed
- Enable USB debugging for a physical device or use an emulator
