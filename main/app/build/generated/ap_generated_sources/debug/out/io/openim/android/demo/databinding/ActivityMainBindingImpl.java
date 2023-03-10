package io.openim.android.demo.databinding;
import io.openim.android.demo.R;
import io.openim.android.demo.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMainBindingImpl extends ActivityMainBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.header, 4);
        sViewsWithIds.put(R.id.avatar, 5);
        sViewsWithIds.put(R.id.isOnline, 6);
        sViewsWithIds.put(R.id.callRecord, 7);
        sViewsWithIds.put(R.id.addFriend, 8);
        sViewsWithIds.put(R.id.fragment_container, 9);
        sViewsWithIds.put(R.id.menuGroup, 10);
        sViewsWithIds.put(R.id.men1, 11);
        sViewsWithIds.put(R.id.men2, 12);
        sViewsWithIds.put(R.id.men3, 13);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @Nullable
    private final io.openim.android.ouicore.databinding.ViewBadgeBinding mboundView2;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener nicknameandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of MainVM.nickname.getValue()
            //         is MainVM.nickname.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(nickname);
            // localize variables for thread safety
            // MainVM.nickname.getValue()
            java.lang.String mainVMNicknameGetValue = null;
            // MainVM.nickname
            androidx.lifecycle.MutableLiveData<java.lang.String> mainVMNickname = null;
            // MainVM != null
            boolean mainVMJavaLangObjectNull = false;
            // MainVM
            io.openim.android.demo.vm.MainVM mainVM = mMainVM;
            // MainVM.nickname != null
            boolean mainVMNicknameJavaLangObjectNull = false;



            mainVMJavaLangObjectNull = (mainVM) != (null);
            if (mainVMJavaLangObjectNull) {


                mainVMNickname = mainVM.nickname;

                mainVMNicknameJavaLangObjectNull = (mainVMNickname) != (null);
                if (mainVMNicknameJavaLangObjectNull) {




                    mainVMNickname.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public ActivityMainBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }
    private ActivityMainBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.ImageView) bindings[8]
            , (io.openim.android.ouicore.widget.AvatarImage) bindings[5]
            , (android.widget.LinearLayout) bindings[2]
            , (android.widget.ImageView) bindings[7]
            , (android.widget.FrameLayout) bindings[9]
            , (androidx.cardview.widget.CardView) bindings[4]
            , (android.widget.LinearLayout) bindings[6]
            , (android.widget.RadioButton) bindings[11]
            , (android.widget.RadioButton) bindings[12]
            , (android.widget.RadioButton) bindings[13]
            , (android.widget.RadioGroup) bindings[10]
            , (android.widget.TextView) bindings[1]
            );
        this.badge.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (bindings[3] != null) ? io.openim.android.ouicore.databinding.ViewBadgeBinding.bind((android.view.View) bindings[3]) : null;
        this.nickname.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
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
        if (BR.MainVM == variableId) {
            setMainVM((io.openim.android.demo.vm.MainVM) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setMainVM(@Nullable io.openim.android.demo.vm.MainVM MainVM) {
        this.mMainVM = MainVM;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.MainVM);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeMainVMNickname((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeMainVMNickname(androidx.lifecycle.MutableLiveData<java.lang.String> MainVMNickname, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
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
        androidx.lifecycle.MutableLiveData<java.lang.String> mainVMNickname = null;
        java.lang.String mainVMNicknameGetValue = null;
        io.openim.android.demo.vm.MainVM mainVM = mMainVM;

        if ((dirtyFlags & 0x7L) != 0) {



                if (mainVM != null) {
                    // read MainVM.nickname
                    mainVMNickname = mainVM.nickname;
                }
                updateLiveDataRegistration(0, mainVMNickname);


                if (mainVMNickname != null) {
                    // read MainVM.nickname.getValue()
                    mainVMNicknameGetValue = mainVMNickname.getValue();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.nickname, mainVMNicknameGetValue);
        }
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.nickname, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, nicknameandroidTextAttrChanged);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): MainVM.nickname
        flag 1 (0x2L): MainVM
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}