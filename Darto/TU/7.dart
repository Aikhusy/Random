void main(List<String> args) {
  var list = [1, 2, null];
  var list2 = [0, ...?list];
  print(list);
  print(list2);
  print(list2.length);
}
