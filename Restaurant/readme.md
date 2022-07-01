## Restaurant Project

I had a lot of issues creating this project, most of which had to do with not completely knowing the different aspects of a thread. Many things needed to be figured out on the fly with the help of hours of YouTube watching. When I did get my bearings on Threads and its methods, the main issue that came up was with my Table.

I added a wait() and a notifyAll() to my Table class but only for its getter and setter. The find method (which is responsible for finding and returning an open spot in the array) has the wait() method. In this method, if an open spot isn’t found it’d return a -1. This is a problem because the index value this method returns is used elsewhere and caused many errors. 

So I tried to put the wait() on a method that checks if all of the Tables are full. However, when I did this my code would only run for the first 4 customers and stop. I don’t know why this happened but I tried various things to bug-fix this. Until I gave up and decided to move the wait() back to my find method.

And after thinking for a bit I put a while loop inside of my find method that makes the thread sleep by 1 millisecond only if the capacity of tables is full. And that actually worked and I still have no idea why putting the wait() inside of the check method didn’t work.

After my code did work, I had an issue with the output of the customers being too linear. But the solution was pretty quick as I only had to switch around some random numbers to make it a bit more spread out.
