import javax.swing.*;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.event.TreeSelectionEvent;
import java.io.File;
import java.text.SimpleDateFormat;

public class Prob4 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        JSplitPane splitPane = new JSplitPane();
        splitPane.setDividerLocation(300);

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        JTree fileTree = new JTree(root);
        JScrollPane treeScrollPane = new JScrollPane(fileTree);

        File rootFile = new File(System.getProperty("user.home"));
        populateTree(root, rootFile);

        String[] columnNames = {"File Name", "Dimension", "Last Modified", "Type"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable fileTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(fileTable);

        splitPane.setLeftComponent(treeScrollPane);
        splitPane.setRightComponent(tableScrollPane);

        fileTree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) fileTree.getLastSelectedPathComponent();
                if (selectedNode != null && selectedNode.getUserObject() instanceof File) {
                    File selectedFile = (File) selectedNode.getUserObject();
                    if (selectedFile.isDirectory()) {
                        updateTable(tableModel, selectedFile);
                    }
                }
            }
        });

        frame.add(splitPane);
        frame.setVisible(true);
    }

    private static void populateTree(DefaultMutableTreeNode node, File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File child : files) {
                DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(child);
                node.add(childNode);
                if (child.isDirectory()) {
                    populateTree(childNode, child);
                }
            }
        }
    }

    private static void updateTable(DefaultTableModel tableModel, File directory) {
        tableModel.setRowCount(0);

        File[] files = directory.listFiles();
        if (files != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for (File file : files) {
                String name = file.getName();
                long size = file.isFile() ? file.length() : 0;
                String lastModified = dateFormat.format(file.lastModified());
                String type = file.isDirectory() ? "Folder" : "File";

                tableModel.addRow(new Object[]{name, size, lastModified, type});
            }
        }
    }
}
