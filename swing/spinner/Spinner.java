
package swing.spinner;

import javax.swing.JSpinner;

/**
 *
 * @author anhth
 */
public class Spinner extends JSpinner{

    public Spinner() {
        setOpaque(false);
        setUI(new SpinnerUI());
    }
    
}
