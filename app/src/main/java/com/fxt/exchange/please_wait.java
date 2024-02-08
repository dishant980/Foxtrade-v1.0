package com.fxt.exchange;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.NonNull;

public class please_wait extends Dialog {
    public please_wait(@NonNull Context context) {
        super(context);


        //This line obtains the current window attributes, such as width, height, and gravity, using the getWindow().getAttributes() method.
        WindowManager.LayoutParams params= getWindow().getAttributes();
        params.gravity = Gravity.CENTER;//it sets the gravity of the window to Gravity.CENTER, which means that the window will be positioned in the center of the screen.
        getWindow().setAttributes(params);//This line applies the modified window attributes to the current window.
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//It sets the window's background to be transparent. This can be useful for creating custom dialog boxes or pop-ups where you want to display content with a transparent background.
        setTitle(null);//This line sets the title of the window to null, effectively removing any title bar or title text from the window. This is often used to create custom dialog boxes or pop-ups without a title.
        setCancelable(false);//It sets the window as non-cancelable, meaning the user cannot dismiss the window by clicking outside of it or pressing the back button. This is often used for dialogs that require a specific action from the user.
        setOnCancelListener(null);//is used to set the cancel listener of a dialog to null, effectively removing any previously set cancel listener.
        View view= LayoutInflater.from(context).inflate(R.layout.please_wait,null);//This line inflates the R.layout.loading layout resource into a View object. The LayoutInflater.from(context) is used to obtain a LayoutInflater instance associated with the given context. Inflating a layout means creating the UI components defined in the XML layout file as Java objects.
        setContentView(view);// This line sets the view as the content view for the LoadingDialog. In other words, it replaces the default content view of the dialog with the custom layout you've inflated.


    }
}
