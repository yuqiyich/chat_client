package io.openim.android.demo.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import io.openim.android.demo.R;
import io.openim.android.demo.databinding.ActivityEditTextBinding;
import io.openim.android.ouicore.base.BaseActivity;
import io.openim.android.ouicore.base.BaseViewModel;
import io.openim.android.ouicore.utils.Constant;
import io.openim.android.ouicore.utils.OnDedrepClickListener;

public class EditTextActivity extends BaseActivity<BaseViewModel, ActivityEditTextBinding> {

    public static final String TITLE = "title";
    public static final String INIT_TXT = "init_txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindViewDataBinding(ActivityEditTextBinding.inflate(getLayoutInflater()));
        sink();
        initView();
    }

    private void initView() {
        view.title.setText(getIntent().getStringExtra(TITLE));
        view.edit.setText(getIntent().getStringExtra(INIT_TXT));
        view.save.setOnClickListener(new OnDedrepClickListener() {
            @Override
            public void click(View v) {
                setResult(RESULT_OK, new Intent().putExtra(Constant.K_RESULT, view.edit.getText().toString()));
                finish();
            }
        });
    }
}
