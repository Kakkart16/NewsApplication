package com.example.newspilot;

        import androidx.fragment.app.Fragment;
        import androidx.fragment.app.FragmentManager;
        import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    int tabcount;

    public PagerAdapter(FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.tabcount = behavior;
    }

    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new homeFragment();
            case 1:
                return new entertainmentFragment();
            case 2:
                return new sportsFragment();
            case 3:
                return new businessFragment();
            case 4:
                return new healthFragment();
            case 5:
                return new scienceFragment();
            case 6:
                return new technologyFragment();
            default:
                return null;
        }
    }

    public int getCount() {
        return this.tabcount;
    }
}
