package custom.camera.test.nick.uiautomator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    private TextView mTextView;
    private EditText mEditText;
    private CheckBox mCheckBox;

    private ListView mListView;
    ArrayList<String> mListItems = new ArrayList<>();
    ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.text_view);
        mEditText = (EditText) findViewById(R.id.edit_text);
        mCheckBox = (CheckBox) findViewById(R.id.checkBox);

        mListView = (ListView) findViewById(R.id.list_view);
        mAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                mListItems);
        mListView.setAdapter(mAdapter);
    }

    public void click(View v)
    {
        String s = mCheckBox.isChecked() ? mEditText.getText().toString().toUpperCase() : mEditText.getText().toString();
        mTextView.setText(s);
        mAdapter.add(s);

    }
}
