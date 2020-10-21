**CPEN 221 / Fall 2020 / Exercise 7**

---

## Hermione's Floo Powder

Hermione has invented a new variant of the flow powder. When used, this allows the user to travel a fixed distance and only a fixed set of distances are possible.

Harry and Ron are going to give this floo powder a trial on a `gridSize x gridSize` grid where Ron will start at position (0, 0) and Harry will start at position `(gridSize-1, gridSize-1)`. The distance between two positions `(r1, c1)` and `(r2, c2)` on the grid is `|r1-r2| + |c1-c2|`. Harry and Ron would like to meet at some position on the grid after `t` time steps, and they use the floo powder in each time step to move to some location on the grid that they can reach using Hermione's floo powder.

In how many possible ways can Harry and Ron meet after `t` time steps? A path is a sequence of positions on the grid that they visit. If they meet at position `(r, c)` after `t` time steps then the number of ways they can meet is: (number of paths for Ron to reach `(r, c)`) x (number of paths for Harry to reach` (r, c)`). You should, of course, solve the problem for all possible meeting positions and, because the number of ways they can meet is very large, return the result modulo 10^8 +11 (or 1e8 + 11).

It is not possible to jump outside the grid. Ron and Harry do not make jumps when none are possible (for example, when the only valid jump distance is 0). Also, they *must* move choose a valid distance at each time step until they have completed `t` time steps.

> Implement the method `GridAndFloo.countMeetingPaths` to return the appropriate count.

**Examples**

1. `gridSize = 1`, `timeSteps = 10`, `jumpDistances = {0, 2}`: In this case, there is only 1 way for Ron and Harry to meet, which is to stay in the same spot.
2. `gridSize = 2`, `timeSteps = 1`, `jumpDistances = {1}`: There are only two ways that Ron and Harry can meet. They can meet at (0, 1) or (1, 0), with Ron and Harry making the appropriate moves.
3. `gridSize = 2`, `timeSteps = 2`, `jumpDistances = {1}`: There are 8 ways that Ron and Harry can meet.
   1. Meet at (0. 0): Harry has two paths and Ron has two paths for 4 ways.
   2. Meet at (1, 1): Harry has two paths and Ron has two paths for 4 ways.
4. `gridSize = 2`, `timeSteps = 3`, `jumpDistances = {1}`: There are 32 ways that Harry and Ron can meet.
   1. Meet at (0, 1): Harry has four paths and Ron has four paths for a total of 16 ways.
   2. Meet at (1, 0): Harry has four paths and Ron has four paths for a total of 16 ways.
5. `gridSize = 10`, `timeSteps = 3`, `jumpDistances = {1}`: There is no way that they can meet.
6. `gridSize = 10`, `timeSteps = 3`, `jumpDistances = {0}`: There is no way that they can meet.
7. `gridSize = 10`, `timeSteps = 3`, `jumpDistances = {0, 3}`: There are 580 ways that they can meet.
8. `gridSize = 4`, `timeSteps = 2`, `jumpDistances = {0, 2}`: There are 48 ways that they can meet.
9. `gridSize = 4`, `timeSteps = 2`, `jumpDistances = {1, 2}`: There are 80 ways that they can meet.
10. `gridSize = 4`, `timeSteps = 2`, `jumpDistances = {2}`: There are 20 ways that they can meet.

## Submitting Your Work

You will submit your work by making changes, committing your work and pushing to GitHub. You must get comfortable with the basic workflow using Git and GitHub. Not being able to push your work to GitHub is not a reasonable excuse for late submissions.

