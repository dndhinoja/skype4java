/*******************************************************************************
 * Copyright (c) 2006 Koji Hisano <hisano@gmail.com>
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 *
 * Contributors:
 *     Koji Hisano - initial API and implementation
 *******************************************************************************/
package jp.sf.skype;

import junit.framework.TestCase;

public class GroupAPITest extends TestCase {
    public void testGetGroup() throws Exception {
        TestUtils.showMessageDialog("���炩����[�e�X�g]�O���[�v���쐬����[" + TestData.getFriendId() + "]��ǉ����Ă����Ă��������B");
        Group group = Skype.getContactList().getGroup("�e�X�g");
        assertNotNull(group);
        assertTrue(group.hasFriend(TestData.getFriend()));
    }

    public void testAddAndRemoveGroup() throws Exception {
        String addedGroupName = "GroupAPITest";
        Group added = Skype.getContactList().addGroup(addedGroupName);
        assertNotNull(Skype.getContactList().getGroup(addedGroupName));
        Skype.getContactList().removeGroup(added);
        assertNull(Skype.getContactList().getGroup(addedGroupName));
    }

    public void testAddAndRemoveFriend() throws Exception {
        Group addedGroup = Skype.getContactList().addGroup("GroupAPITest");
        Friend addedFriend = TestData.getFriend();
        addedGroup.addFriend(addedFriend);
        assertTrue(addedGroup.hasFriend(addedFriend));
        addedGroup.removeFriend(addedFriend);
        assertFalse(addedGroup.hasFriend(addedFriend));
        Skype.getContactList().removeGroup(addedGroup);
    }
}