import 'screens/input_page.dart';
import 'package:flutter/material.dart';

class CalculatorBrain {
  CalculatorBrain({this.height, this.weight});
  final int height;
  final int weight;

  double _bmi;

  String calculateBMI() {
    _bmi = ((703 * weight.toDouble()) / (height * height));
    return _bmi.toStringAsFixed(1);
  }

  String getResult() {
    calculateBMI();
    if (_bmi >= 25) {
      return 'Overweight';
    } else if (_bmi > 18.5) {
      return 'Normal';
    } else {
      return 'Underweight';
    }
  }

  String getInterpretation() {
    if (_bmi >= 25) {
      return 'You have a higher than normal BMI. Try excersising more.';
    } else if (_bmi > 18.5) {
      return 'You have a normal BMI. Good Job!';
    } else {
      return 'You have a lower than normal body weight. You should eat a bit more. ';
    }
  }

  Color getColor() {
    if (_bmi >= 25) {
      return Colors.orange;
    } else if (_bmi > 18.5) {
      return Colors.green;
    } else {
      return Colors.orange;
    }
  }
}
