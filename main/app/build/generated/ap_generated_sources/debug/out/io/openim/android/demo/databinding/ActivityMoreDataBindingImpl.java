package io.openim.android.demo.databinding;
import io.openim.android.demo.R;
import io.openim.android.demo.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMoreDataBindingImpl extends ActivityMoreDataBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.back, 2);
        sViewsWithIds.put(R.id.avatarLy, 8);
        sViewsWithIds.put(R.id.avatar, 9);
        sViewsWithIds.put(R.id.nickNameLy, 10);
        sViewsWithIds.put(R.id.nickName, 11);
        sViewsWithIds.put(R.id.genderLy, 12);
        sViewsWithIds.put(R.id.gender, 13);
        sViewsWithIds.put(R.id.birthdayLy, 14);
        sViewsWithIds.put(R.id.birthday, 15);
        sViewsWithIds.put(R.id.qrCode, 16);
        sViewsWithIds.put(R.id.phoneTv, 17);
        sViewsWithIds.put(R.id.idLy, 18);
        sViewsWithIds.put(R.id.mailTv, 19);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @Nullable
    private final io.openim.android.ouicore.databinding.ViewDividingLineBinding mboundView01;
    @Nullable
    private final io.openim.android.ouicore.databinding.ViewDividingLineBinding mboundView02;
    @Nullable
    private final io.openim.android.ouicore.databinding.ViewDividingLineBinding mboundView03;
    @Nullable
    private final io.openim.android.ouicore.databinding.ViewDividingLineBinding mboundView04;
    @Nullable
    private final io.openim.android.ouicore.databinding.ViewDividingLineBinding mboundView05;
    @NonNull
    private final android.widget.RelativeLayout mboundView1;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMoreDataBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 20, sIncludes, sViewsWithIds));
    }
    private ActivityMoreDataBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (io.openim.android.ouicore.widget.AvatarImage) bindings[9]
            , (android.widget.LinearLayout) bindings[8]
            , (bindings[2] != null) ? io.openim.android.ouicore.databinding.ViewBackBinding.bind((android.view.View) bindings[2]) : null
            , (android.widget.TextView) bindings[15]
            , (android.widget.LinearLayout) bindings[14]
            , (android.widget.TextView) bindings[13]
            , (android.widget.LinearLayout) bindings[12]
            , (android.widget.LinearLayout) bindings[18]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[11]
            , (android.widget.LinearLayout) bindings[10]
            , (android.widget.TextView) bindings[17]
            , (android.widget.LinearLayout) bindings[16]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView01 = (bindings[3] != null) ? io.openim.android.ouicore.databinding.ViewDividingLineBinding.bind((android.view.View) bindings[3]) : null;
        this.mboundView02 = (bindings[4] != null) ? io.openim.android.ouicore.databinding.ViewDividingLineBinding.bind((android.view.View) bindings[4]) : null;
        this.mboundView03 = (bindings[5] != null) ? io.openim.android.ouicore.databinding.ViewDividingLineBinding.bind((android.view.View) bindings[5]) : null;
        this.mboundView04 = (bindings[6] != null) ? io.openim.android.ouicore.databinding.ViewDividingLineBinding.bind((android.view.View) bindings[6]) : null;
        this.mboundView05 = (bindings[7] != null) ? io.openim.android.ouicore.databinding.ViewDividingLineBinding.bind((android.view.View) bindings[7]) : null;
        this.mboundView1 = (android.widget.RelativeLayout) bindings[1];
        this.mboundView1.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}