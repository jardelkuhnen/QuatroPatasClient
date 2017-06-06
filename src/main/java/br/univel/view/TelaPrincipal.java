package br.univel.view;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.jboss.as.quickstarts.ejb.remote.client.RemoteEJBClient;

import br.univel.dao.AnimalDao;
import br.univel.model.Animal;
import br.univel.model.AnimalModel;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEspecie;
	private JTextField txtProprietario;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private AnimalDao dao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 217, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 1;
		contentPane.add(lblNome, gbc_lblNome);

		txtNome = new JTextField();
		GridBagConstraints gbc_txtNome = new GridBagConstraints();
		gbc_txtNome.gridwidth = 2;
		gbc_txtNome.insets = new Insets(0, 0, 5, 5);
		gbc_txtNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNome.gridx = 1;
		gbc_txtNome.gridy = 1;
		contentPane.add(txtNome, gbc_txtNome);
		txtNome.setColumns(10);

		JLabel lblEspcie = new JLabel("Espécie");
		GridBagConstraints gbc_lblEspcie = new GridBagConstraints();
		gbc_lblEspcie.anchor = GridBagConstraints.EAST;
		gbc_lblEspcie.insets = new Insets(0, 0, 5, 5);
		gbc_lblEspcie.gridx = 0;
		gbc_lblEspcie.gridy = 2;
		contentPane.add(lblEspcie, gbc_lblEspcie);

		txtEspecie = new JTextField();
		GridBagConstraints gbc_txtEspecie = new GridBagConstraints();
		gbc_txtEspecie.gridwidth = 2;
		gbc_txtEspecie.insets = new Insets(0, 0, 5, 5);
		gbc_txtEspecie.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEspecie.gridx = 1;
		gbc_txtEspecie.gridy = 2;
		contentPane.add(txtEspecie, gbc_txtEspecie);
		txtEspecie.setColumns(10);

		JLabel lblProprietrio = new JLabel("Proprietário");
		GridBagConstraints gbc_lblProprietrio = new GridBagConstraints();
		gbc_lblProprietrio.anchor = GridBagConstraints.EAST;
		gbc_lblProprietrio.insets = new Insets(0, 0, 5, 5);
		gbc_lblProprietrio.gridx = 0;
		gbc_lblProprietrio.gridy = 3;
		contentPane.add(lblProprietrio, gbc_lblProprietrio);

		txtProprietario = new JTextField();
		GridBagConstraints gbc_txtProprietario = new GridBagConstraints();
		gbc_txtProprietario.gridwidth = 2;
		gbc_txtProprietario.insets = new Insets(0, 0, 5, 5);
		gbc_txtProprietario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtProprietario.gridx = 1;
		gbc_txtProprietario.gridy = 3;
		contentPane.add(txtProprietario, gbc_txtProprietario);
		txtProprietario.setColumns(10);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 4;
		contentPane.add(scrollPane, gbc_scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		btnNewButton_2 = new JButton("Novo");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Animal animal = new Animal();
				animal.setNome(txtNome.getText());
				animal.setProprietario(txtProprietario.getText());
				animal.setEspecie(txtEspecie.getText());

				dao.create(animal);

			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_2.gridx = 2;
		gbc_btnNewButton_2.gridy = 5;
		contentPane.add(btnNewButton_2, gbc_btnNewButton_2);

		btnNewButton_1 = new JButton("Salvar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 5;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);

		btnNewButton = new JButton("Excluir");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 5;
		contentPane.add(btnNewButton, gbc_btnNewButton);

		try {

			dao = RemoteEJBClient.lookupRemoteStatelessCalculator();

		} catch (NamingException e) {
			e.printStackTrace();
		}

		configuratabela(dao.getAll());

	}

	private void configuratabela(ArrayList<Animal> list) {

		AnimalModel model = new AnimalModel(list);
		table.setModel(model);
	}

}
