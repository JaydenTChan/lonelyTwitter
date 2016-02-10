package ca.ualberta.cs.lonelytwitter;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.view.View;
import android.widget.TextView;

/**
 * Created by sajediba on 2/8/16.
 */
public class IntentReaderActivityTest extends ActivityInstrumentationTestCase2{

    public IntentReaderActivityTest() {
        super(IntentReaderActivity.class);
    }

    //
    //
    public void testSendText(){
        Intent intent = new Intent();
        intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "message 1");

        setActivityIntent(intent);
        IntentReaderActivity ira = (IntentReaderActivity)getActivity();

        assertEquals("IntentReaderActivity should get the text from intent",
                "message 1", ira.getText());

    }

    public void testDisplayText(){
        Intent intent = new Intent();
        intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "message 2");

        setActivityIntent(intent);
        IntentReaderActivity ira = (IntentReaderActivity)getActivity();

        TextView textView = (TextView) ira.findViewById(R.id.intentText);
        assertEquals("The text should be displayed!", "message 2", textView.getText());
    }

    public void testDoubleText(){
        Intent intent = new Intent();
        intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "message 3");
        intent.putExtra(IntentReaderActivity.MODE_OF_TRANSFORM_KEY,
                IntentReaderActivity.DOUBLE);

        setActivityIntent(intent);
        IntentReaderActivity ira = (IntentReaderActivity)getActivity();

        assertEquals("This test should be repeated twice!", "message 3message 3", ira.getText());
    }



    //
    //

    //TODO: Add your code here ...
//-------------------------------------------------------------------------------
    public void testReverseText(){
        Intent intent = new Intent();
        intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "message 4");
        intent.putExtra(IntentReaderActivity.MODE_OF_TRANSFORM_KEY,
                IntentReaderActivity.REVERSE);

        setActivityIntent(intent);
        IntentReaderActivity ira = (IntentReaderActivity)getActivity();

        assertEquals("This test should be backwards!", "4 egassem", ira.getText());
    }

    public void testDefaultText(){
        Intent intent = new Intent();

        setActivityIntent(intent);
        IntentReaderActivity ira = (IntentReaderActivity)getActivity();

        assertEquals("This test should be backwards!", "default text", ira.getText());
    }

    public void testTextShown(){
        Intent intent = new Intent();

        setActivityIntent(intent);
        IntentReaderActivity ira = (IntentReaderActivity) getActivity();

        final View view = ira.findViewById(R.id.intentText);

        final View origin = ira.getWindow().getDecorView();

        ViewAsserts.assertOnScreen(origin, view);

    }
//-------------------------------------------------------------------------------
}
