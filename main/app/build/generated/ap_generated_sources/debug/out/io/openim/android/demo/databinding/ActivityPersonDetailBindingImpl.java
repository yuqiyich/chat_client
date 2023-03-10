package io.openim.android.demo.databinding;
import io.openim.android.demo.R;
import io.openim.android.demo.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityPersonDetailBindingImpl extends ActivityPersonDetailBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.back, 3);
        sViewsWithIds.put(R.id.nickName, 5);
        sViewsWithIds.put(R.id.avatar, 6);
        sViewsWithIds.put(R.id.userId, 7);
        sViewsWithIds.put(R.id.userInfo, 8);
        sViewsWithIds.put(R.id.sendMsg, 9);
        sViewsWithIds.put(R.id.call, 10);
        sViewsWithIds.put(R.id.addFriend, 11);
        sViewsWithIds.put(R.id.part, 12);
    }
    // views
    @NonNull
    private final android.widget.FrameLayout mboundView0;
    @NonNull
    private final android.widget.RelativeLayout mboundView1;
    @NonNull
    private final android.widget.LinearLayout mboundView2;
    @Nullable
    private final io.openim.android.ouicore.databinding.ViewDividingLineBinding mboundView21;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityPersonDetailBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }
    private ActivityPersonDetailBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.RadioButton) bindings[11]
            , (io.openim.android.ouicore.widget.AvatarImage) bindings[6]
            , (bindings[3] != null) ? io.openim.android.ouicore.databinding.ViewBackBinding.bind((android.view.View) bindings[3]) : null
            , (android.widget.RadioButton) bindings[10]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[12]
            , (android.widget.RadioButton) bindings[9]
            , (android.widget.TextView) bindings[7]
            , (android.widget.LinearLayout) bindings[8]
            );
        this.mboundView0 = (android.widget.FrameLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.RelativeLayout) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (android.widget.LinearLayout) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView21 = (bindings[4] != null) ? io.openim.android.ouicore.databinding.ViewDividingLineBinding.bind((android.view.View) bindings[4]) : null;
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