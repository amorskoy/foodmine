# FYI

Absolutely no input argument validation performed (like CSV file existence, format checks etc...)

You need scala 2.11 and sbt (0.13.* preferrable) to work with this project

# Test run

Cd into project dir

**sbt test**

# Deploy as java jar (need sbt-assembly plugin added to project/plugins.sbt)

Cd into project dir

** sbt assembly **

Then you could run:

** java -cp target/scala-2.11/foodmine.jar foodmine.runner.ActiveUsersRunner ./src/test/resources/test.csv **

To run in low memory mode:

** java -Xms256m -Xmx384m -cp target/scala-2.11/foodmine.jar foodmine.runner.ActiveUsersRunner ./src/test/resources/test.csv **


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
