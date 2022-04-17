package Controllers;

import Models.Todo;
import Views.HomeView;
import Views.Inc.ErrMsg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HomeController {

    HomeView homeView;
    JPanel listPanel;
    JButton addButton;
    JTextField textField;

    public HomeController(HomeView homeView){
        this.homeView = homeView;

        this.listPanel = homeView.getListPanel();

        this.homeView.getAddButton().setVisible(false);

        displayNotes();

        this.homeView.getNoteField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (checkField())
                    homeView.getAddButton().setVisible(true);
                else
                    homeView.getAddButton().setVisible(false);
            }
        });

        homeView.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    hideAllErrMsg();
                if (homeView.getNoteField().getText().length() < 51) {
                    if (Todo.create(homeView.getNoteField().getText())) {
                        refreshNotes();
                        homeView.getNoteField().setText("");
                    }else
                        showDbErrMsg();
                } else
                    showCountErrMsg();
            }
        });
    }

    boolean checkField(){
        return homeView.getNoteField().getText().length() > 0;
    }

    void displayNotes(){
        if (Todo.getUserNotes()){
            try{
                ResultSet rs = Todo.getResultSet();
                while(rs.next()){
                    listPanel.add(createNote(rs.getString("note"), rs.getInt("id")));

                    listPanel.revalidate();
                    listPanel.repaint();
                }
            }catch(SQLException e){
                System.out.println("error displaying data");
            }
        }
    }

    void refreshNotes(){
        listPanel.removeAll();
        displayNotes();
    }

    void showDbErrMsg(){
        homeView.getDbErrMsg().setVisible(true);
    }

    void showCountErrMsg(){
        homeView.getCountErrMsg().setVisible(true);
    }

    void hideDbErrMsg(){
        homeView.getDbErrMsg().setVisible(false);
    }

    void hideCountErrMsg(){
        homeView.getDbErrMsg().setVisible(false);
    }

    void hideAllErrMsg(){
        hideDbErrMsg();
        hideCountErrMsg();
    }

    public JPanel createNote(String note, int id){

        // hidden id
        JLabel note_id = new JLabel(String.valueOf(id));
        note_id.setVisible(false);

        //note panel
        JPanel notePanel = new JPanel();
        notePanel.setLayout(new BoxLayout(notePanel, BoxLayout.X_AXIS));
        notePanel.add(Box.createRigidArea(new Dimension(5, 0)));

        //note
        notePanel.add(new JLabel(note));
        notePanel.add(Box.createHorizontalGlue());

        //icon
        JLabel deleteBtn = new JLabel(new ImageIcon("src/Icons/bin.png"));
        notePanel.add(deleteBtn);
        notePanel.add(Box.createRigidArea(new Dimension(5, 0)));

        // grouping all in a parent panel
        JPanel parent = new JPanel();
        parent.setLayout(new BoxLayout(parent, BoxLayout.Y_AXIS));

        parent.add(note_id);
        parent.add(notePanel);
        parent.add(Box.createRigidArea(new Dimension(0, 20)));

        // listeners
        deleteBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                deleteNote(parent);
            }
        });


        return parent;
    }

    void deleteNote(JPanel notePanel){
        // get note Id
        int id = getNoteId(notePanel);

        Todo.deleteNote(id);

        listPanel.remove(notePanel);
        listPanel.revalidate();
        listPanel.repaint();
    }

    int getNoteId(JPanel notePanel){

        if (notePanel.getComponent(0) instanceof  JLabel){
            return Integer.parseInt(((JLabel) notePanel.getComponent(0)).getText());
        }
        return 0;
    }
}
