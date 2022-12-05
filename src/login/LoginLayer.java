package login;

import storage.Storage;

public class LoginLayer {

	public boolean isAccountAvailable(int id, String password) {
		// TODO Auto-generated method stub
		if(Storage.VALUES.getUserDetails().containsKey(id) && Storage.VALUES.getUserDetails().get(id).getPassword().equals(password)) {
			return true;
		}
		return false;
	}

}
