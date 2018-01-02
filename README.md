# Android Test Menu

A simple menu for testing custom android functions without the need of developing your own UI.

It brings a a simple view where you can add buttons using
```java
GenerateButton(string buttonName, ButtonClick click);
```

`ButtonClick` being a simple interface with one void method. 
So, for adding a button to exit the application, you could add the following:
```java
GenerateButton("Quit", new ButtonClick() {
    @Override
    public void click() {
        finishAffinity();
        System.exit(0);
    }
});
```