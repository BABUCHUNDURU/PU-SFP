def courses = primaryProgram.getCourses().getStartingIn(period);
def firstAra = !courses.isEmpty() && courses.asFluent().toSortedList({ c1, c2 -> c1.getStartDate().compareTo(c2.getStartDate())}).get(0).getFirstAraIndicator();
return firstAra;