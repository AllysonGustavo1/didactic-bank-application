package bank;

import bank.business.AccountManagementService;
import bank.business.domain.ATM;
import bank.business.domain.Branch;
import bank.business.impl.AccountOperationServiceImpl;
import bank.ui.BankInterface;
import bank.ui.graphic.ATMGUIInterface;
import bank.ui.graphic.BranchGUIInterface;
import bank.ui.text.UIUtils;

/**
 * @author ingrid
 */
public class BankGraphic extends Bank {

	/**
	 * Creates the ATM interface.
	 *
	 * @param atm The ATM instance associated with the interface.
	 * @param accountOperationService The service for account operations.
	 * @return A graphical ATM interface.
	 */
	//@ requires atm != null && accountOperationService != null;
	//@ ensures \result != null;
	@Override
	public BankInterface createATMInterface(ATM atm,
											AccountOperationServiceImpl accountOperationService) {
		return new ATMGUIInterface(atm, UIUtils.INSTANCE.getTextManager(),
				accountOperationService);
	}

	/**
	 * Creates the Branch interface.
	 *
	 * @param branch The branch instance associated with the interface.
	 * @param accountManagementService The service for account management.
	 * @param accountOperationService The service for account operations.
	 * @return A graphical Branch interface.
	 */
	//@ requires branch != null && accountManagementService != null && accountOperationService != null;
	//@ ensures \result != null;
	@Override
	public BankInterface createBranchInterface(Branch branch,
											   AccountManagementService accountManagementService,
											   AccountOperationServiceImpl accountOperationService) {
		return new BranchGUIInterface(branch,
				UIUtils.INSTANCE.getTextManager(), accountManagementService,
				accountOperationService);
	}

	/**
	 * Displays the user interface for all bank interfaces.
	 */
	//@ ensures \forall BankInterface bi; bankInterfaces.contains(bi); bi != null;
	public void showUI() {
		for (BankInterface bankInterface : bankInterfaces) {
			bankInterface.createAndShowUI();
		}
	}
}
