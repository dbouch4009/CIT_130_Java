README

Mr Acklin,

To launch this program, navigate to Bouch_Middle_Man\out\artifacts\Bouch_Middle_Man_jar directory in your command line and key in:
java -jar Bouch_Middle_Man.jar

This will launch the other two .jar files, which are the Writer and Reader, respectively. They will all three be in separate windows.

Key your text into the top box of the Writer's GUI, and press enter to begin the chain of encryption and decrytion.

I had trouble visualizing how this project would work, so I assigned a GUI to each socket after following some online resources that explained how to set up a box.

I spent the better part of three whole days trying to get the encrypt/decrypt to work. When I finally threw in the towel earlier tonight and put the .jar files in the same directory, the decrytion magically began to work.

I'm not offering explanations, but I just wanted to let you know how much trouble it was!

There's a line of code commented out in the Write_Client.java class that has the seed of getting the scanned in messages to push every half second. I tried a few different ways, but was unable to achieve this in the time allotted.

The Middle Man and Read Clients both include some debugging information in their boxes, and I used the ShowMessage() method to display it. It was helpful for me to track what was going on, so maybe you would like it too.

The source code to the two clients and the server is in a .zip file labeled "source code."

I thought this was a good class this year.

Thank You,

Damian Bouch

