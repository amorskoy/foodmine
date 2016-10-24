# FYI

Absolutely no input argument validation performed (like CSV file existence, format checks etc...)

You need scala 2.11 and sbt (0.13.* preferrable) to work with this project

Monitor CPU cores usage percantage per core:

**ps -p $PID -L -o pid,tid,psr,pcpu**

Other way is to use **perf stat** from linux-tools-3.16:

**perf stat java -cp dist/foodmine.jar foodmine.runner.TopWordsRunner $IN_FILE**
```      67617.755084      task-clock (msec)         #    1.060 CPUs utilized
             18,222      context-switches          #    0.269 K/sec
              2,762      cpu-migrations            #    0.041 K/sec
            237,828      page-faults               #    0.004 M/sec
    229,094,541,747      cycles                    #    3.388 GHz
    <not supported>      stalled-cycles-frontend
    <not supported>      stalled-cycles-backend
    334,734,883,389      instructions              #    1.46  insns per cycle
     57,934,848,913      branches                  #  856.799 M/sec
      1,695,249,931      branch-misses             #    2.93% of all branches

       63.790462429 seconds time elapsed
```

# Test run

Cd into project dir

**sbt test**

# Deploy as java jar

You need sbt-assembly plugin added to project/plugins.sbt

Cd into project dir

**sbt assembly**

Then you could run:

**java -cp dist/foodmine.jar foodmine.runner.ActiveUsersRunner ./src/test/resources/test.csv**

To run in low memory mode:

**java -Xms256m -Xmx384m -cp dist/foodmine.jar foodmine.runner.ActiveUsersRunner ./src/test/resources/test.csv**


#Runners:

Cd into project dir

## Top active users

**sbt "run-main foodmine.runner.ActiveUsersRunner ./src/test/resources/test.csv"**

## Top commented items

**sbt "run-main foodmine.runner.CommentedItemsRunner ./src/test/resources/test.csv"**

## Top words used in comments

**sbt "run-main foodmine.runner.TopWordsRunner ./src/test/resources/test.csv"**


# Outputs

## Top words:
`...
(you,280382)
(not,285094)
(was,307861)
(are,310933)
(but,324932)
(have,335286)
(with,336250)
(my,364021)
(that,400467)
(this,488313)
(in,512394)
(for,519983)
(it,631252)
(is,714264)
(of,789652)
(,989963)
(to,992367)
(a,1163164)
(and,1228666)
(I,1388076)
(the,1628045)
`

## Top users:
`...
(Linda,296)
(Chris,363)
(Rebecca of Amazon "The Rebecca Review",368)
(Gary Peterson,389)
(O. Brown "Ms. O. Khannah-Brown",426)
(C. F. Hill "CFH",451)
`

## Top items
`....
(B003B3OOPA,762)
(B001RVFERK,763)
(B005K4Q34S,763)
(B002QWP8H0,766)
(B006HYLW32,792)
(B007JFMH8M,1149)
`
