package unit.com.bitdubai.sub_app.crypto_customer_community.fragmentFactory.CryptoCustomerCommunityFragmentFactory;

import com.bitdubai.fermat_android_api.layer.definition.wallet.AbstractFermatFragment;
import com.bitdubai.fermat_android_api.layer.definition.wallet.exceptions.FragmentNotFoundException;
import com.bitdubai.sub_app.crypto_customer_community.fragmentFactory.CryptoCustomerCommunityFragmentFactory;
import com.bitdubai.sub_app.crypto_customer_community.fragmentFactory.CryptoCustomerCommunityFragmentsEnumType;

import org.junit.Before;
import org.junit.Test;

import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;
import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by nelson on 17/09/15.
 */
public class GetFermatFragmentTest {
    private CryptoCustomerCommunityFragmentFactory fragmentFactory;
    private final String ENUM_TYPE_CODE = "MF";


    @Before
    public void setUp() throws Exception {
        fragmentFactory = new CryptoCustomerCommunityFragmentFactory();
    }

    @Test
    public void fragmentFound() throws Exception {
        CryptoCustomerCommunityFragmentsEnumType enumType = fragmentFactory.getFermatFragmentEnumType(ENUM_TYPE_CODE);
        AbstractFermatFragment actualFragment = fragmentFactory.getFermatFragment(enumType);

        assertThat(actualFragment).isInstanceOf(AbstractFermatFragment.class);
    }

    @Test
    public void fragmentNotFound() throws Exception {
        catchException(fragmentFactory).getFermatFragment(null);

        assertThat(caughtException()).isInstanceOf(FragmentNotFoundException.class);
    }
}