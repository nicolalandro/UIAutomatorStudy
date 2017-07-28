package custom.camera.test.nick.uiautomator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    private TextView mTextView;
    private EditText mEditText;
    private CheckBox mCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.text_view);
        mEditText = (EditText) findViewById(R.id.edit_text);
        mCheckBox = (CheckBox) findViewById(R.id.checkBox);
    }

    public void click(View v) {
        if(mCheckBox.isChecked()){
            mTextView.setText(mEditText.getText().toString().toUpperCase());
        }
        else
        {
            mTextView.setText(mEditText.getText());
        }
    }
}
