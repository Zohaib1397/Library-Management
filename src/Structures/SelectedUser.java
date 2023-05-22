package Structures;

/*------------------------------------------------------------
 * This following static function maintain the record of current user it will detect based on the database
 * if the database isAdmin is false then the current user will automatically be switched to the customer status
 * in general it is a State Management Enum Class
 * -----------------------------------------------------------*/
public enum SelectedUser {
    ADMIN,
    CUSTOMER
}
