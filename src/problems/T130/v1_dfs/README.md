https://leetcode.com/submissions/detail/133211512/

Submission Detail

59 / 59 test cases passed.

Status: Accepted

Runtime: 10 ms

Submitted: 0 minutes ago

***
我的思路基本就是DFS.

    X X X X
    X O O X
    X X O X
    X O X X
    ->
    R R R R R R
    R X X X X R
    R X O O X R
    R X X O X R
    R X O X X R
    R R R R R R
    ->
    //将与R相邻的O传染成R
    R R R R R R
    R X X X X R
    R X O O X R
    R X X O X R
    R X R X X R
    R R R R R R   
    ->
    //将剩下的所有O改成X
    R R R R R R
    R X X X X R
    R X X X X R
    R X X X X R
    R X R X X R
    R R R R R R  
    ->
    //将board内的R改回O
    R R R R R R
    R X X X X R
    R X X X X R
    R X X X X R
    R X O X X R
    R R R R R R    
    ->
     X X X X 
     X X X X 
     X X X X 
     X O X X        
    