package com.k172dev.redmine_client;

import java.util.List;
import java.util.Vector;

import com.k172dev.redmine_client.fragments.CreatedTasksFragment;
import com.k172dev.redmine_client.fragments.MyTasksFragment;
import com.k172dev.redmine_client.fragments.ProjectsTreeFragment;

import android.os.Bundle;
import android.support.v4.app.*;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.*;
import android.widget.TextView;

/*
 * package com.k172dev.redmine_client;
 * 
 * import android.os.Bundle; import android.app.Activity; import android.view.Menu;
 * 
 * public class MainActivity extends Activity {
 * 
 * @Override public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);
 * setContentView(R.layout.activity_main); }
 * 
 * @Override public boolean onCreateOptionsMenu(Menu menu) {
 * getMenuInflater().inflate(R.menu.activity_main, menu); return true; } }
 */
public class MainActivity extends FragmentActivity {
	/*    // When requested, this adapter returns a DemoObjectFragment,
	    // representing an object in the collection.
	    DemoCollectionPagerAdapter mDemoCollectionPagerAdapter;
	    ViewPager mViewPager;

	    public void onCreate(Bundle savedInstanceState) {
	    	super.onCreate(savedInstanceState);
	        // ViewPager and its adapters use support library
	        // fragments, so use getSupportFragmentManager.
	        mDemoCollectionPagerAdapter =
	                new DemoCollectionPagerAdapter(
	                        getSupportFragmentManager());
	        mViewPager = (ViewPager) findViewById(R.id.pager);
	        if (mViewPager != null)
	        	mViewPager.setAdapter(mDemoCollectionPagerAdapter);
	    }
	*/

	private PagerAdapter mPagerAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.viewpager_layout);

		// initialize the pager
		this.initialisePaging();
	}

	/**
	 * Initialize the fragments to be paged
	 */
	private void initialisePaging() {

		List<Fragment> fragments = new Vector<Fragment>();
		fragments.add(Fragment.instantiate(this, MyTasksFragment.class.getName()));
		fragments.add(Fragment.instantiate(this, ProjectsTreeFragment.class.getName()));
		fragments.add(Fragment.instantiate(this, CreatedTasksFragment.class.getName()));
		this.mPagerAdapter = new SwipePagerAdapter(super.getSupportFragmentManager(), fragments);

		ViewPager pager = (ViewPager) super.findViewById(R.id.smoothswipepager);
		pager.setAdapter(this.mPagerAdapter);
	}

// Since this is an object collection, use a FragmentStatePagerAdapter,
// and NOT a FragmentPagerAdapter.
	/*class DemoCollectionPagerAdapter extends
	        FragmentStatePagerAdapter {
	    public DemoCollectionPagerAdapter(FragmentManager fm) {
	        super(fm);
	    }

	    @Override
	    public Fragment getItem(int i) {
	        Fragment fragment = new DemoObjectFragment();
	        Bundle args = new Bundle();
	        // Our object is just an integer :-P
	        args.putInt(DemoObjectFragment.ARG_OBJECT, i + 1);
	        fragment.setArguments(args);
	        return fragment;
	    }

	    @Override
	    public int getCount() {
	        return 100;
	    }

	    @Override
	    public CharSequence getPageTitle(int position) {
	        return "OBJECT " + (position + 1);
	    }
	}

	// Instances of this class are fragments representing a single
	// object in our collection.
	 class DemoObjectFragment extends Fragment {
	    public static final String ARG_OBJECT = "object";

	    @Override
	    public View onCreateView(LayoutInflater inflater,
	            ViewGroup container, Bundle savedInstanceState) {
	        // The last two arguments ensure LayoutParams are inflated
	        // properly.
	        View rootView = inflater.inflate(
	                R.layout.activity_main, container, false);
	        Bundle args = getArguments();
	        ((TextView) rootView.findViewById(android.R.id.text1)).setText(
	                Integer.toString(args.getInt(ARG_OBJECT)));
	        return rootView;
	    }*/
}