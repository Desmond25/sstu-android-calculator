package com.example.project2;

public class CalculatorModel {

    private float firstArg;
    private float secondArg;

    private StringBuilder inputStr = new StringBuilder();

    private int actionSelected;

    private State state;

    private enum State {
        firstArgInput,
        secondArgInput,
        resultShow
    }

    public CalculatorModel() {
        state = State.firstArgInput;
    }

    public void onNumPressed(int buttonId) {

        if (state == State.resultShow) {
            state = State.firstArgInput;
            inputStr.setLength(0);
            inputStr.append("0");
        }

        if (inputStr.length() < 9) {
            if (inputStr.toString().startsWith("0") && !inputStr.toString().startsWith("0.")) {
                inputStr.setLength(0);
            }
            switch (buttonId) {
                case R.id.n0:
                    inputStr.append("0");
                    break;
                case R.id.n1:
                    inputStr.append("1");
                    break;
                case R.id.n2:
                    inputStr.append("2");
                    break;
                case R.id.n3:
                    inputStr.append("3");
                    break;
                case R.id.n4:
                    inputStr.append("4");
                    break;
                case R.id.n5:
                    inputStr.append("5");
                    break;
                case R.id.n6:
                    inputStr.append("6");
                    break;
                case R.id.n7:
                    inputStr.append("7");
                    break;
                case R.id.n8:
                    inputStr.append("8");
                    break;
                case R.id.n9:
                    inputStr.append("9");
                    break;
                case R.id.dot:
                    if (inputStr.length() == 0) {
                        inputStr.append("0");
                    }
                    if (!inputStr.toString().contains(".")){
                        inputStr.append(".");
                    }
                    break;
            }
        }
    }

    public void onActionPressed(int actionId) {

        if (actionId == R.id.equals && state == State.secondArgInput) {
            secondArg = Float.parseFloat(inputStr.toString());
            state = State.resultShow;
            inputStr.setLength(0);
            switch (actionSelected) {
                case R.id.plus:
                    inputStr.append(firstArg + secondArg);
                    break;
                case R.id.minus:
                    inputStr.append(firstArg - secondArg);
                    break;
                case R.id.division:
                    if (secondArg == 0) {
                        inputStr.append("Err");
                    } else {
                        inputStr.append(firstArg / secondArg);
                    }
                    break;
                case R.id.multiply:
                    inputStr.append(firstArg * secondArg);
                    break;
            }

        } else if (inputStr.length() > 0 && state == State.firstArgInput) {
            firstArg = Float.parseFloat(inputStr.toString());
            state = State.secondArgInput;
            inputStr.setLength(0);
            inputStr.append("0");

            switch (actionId) {
                case R.id.plus:
                    actionSelected = R.id.plus;
                    break;
                case R.id.minus:
                    actionSelected = R.id.minus;
                    break;
                case R.id.division:
                    actionSelected = R.id.division;
                    break;
                case R.id.multiply:
                    actionSelected = R.id.multiply;
                    break;
                case R.id.sqrt:
                    state = State.resultShow;
                    inputStr.append(Math.sqrt(firstArg));
                    break;
                case R.id.fraction:
                    state = State.resultShow;
                    inputStr.append(1/firstArg);
                    break;
                case R.id.toggleSign:
                    state = State.resultShow;
                    firstArg *= -1;
                    inputStr.append(firstArg);
                    break;
            }
        }else if (actionId == R.id.clear) {
            state = State.firstArgInput;
            inputStr.setLength(0);
            inputStr.append("0");
        }
    }

    public String getText() {
        return inputStr.toString();
    }
}
