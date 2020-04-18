import 'package:flutter/material.dart';

class ReusableCard extends StatelessWidget {
  ReusableCard({@required this.color, this.cardChild, this.onClick});
  final Color color;
  final Widget cardChild;
  final Function onClick;

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      child: Container(
        margin: EdgeInsets.all(15.0),
        decoration: BoxDecoration(
            borderRadius: BorderRadius.circular(10.0), color: color),
        child: cardChild,
      ),
      onTap: () {
        onClick();
        print('clicked');
      },
    );
  }
}
