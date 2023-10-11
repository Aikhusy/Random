void main(List<String> args) {
  var listOfInt = [1, 2, 3];
  var listOfStrings = ['#0', for (var i in listOfInt) '#$i'];
  assert(listOfStrings[1] == '#1');
  print(listOfStrings);
}
