package br.univel.view;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Serializable;

import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import org.jboss.as.quickstarts.ejb.remote.client.RemoteEJBClient;

import br.univel.dao.AnimalDao;
import br.univel.model.Animal;
import br.univel.model.AnimalModel;

public class TelaPrincipal extends JFrame implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEspecie;
	private JTextField txtProprietario;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnExcluir;
	private JButton btnEditar;
	private JButton btnNovo;
	private AnimalDao dao;
	private AnimalModel model;
	private Animal animalSelecionado;
	private int idAnimalEditar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
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

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
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
		txtProprietario.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == e.VK_ENTER) {

					createUpdate();
					txtNome.requestFocus();

				}

			}

		});
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

		btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				createUpdate();

			}

		});
		GridBagConstraints gbc_btnNovo = new GridBagConstraints();
		gbc_btnNovo.insets = new Insets(0, 0, 0, 5);
		gbc_btnNovo.gridx = 2;
		gbc_btnNovo.gridy = 5;
		contentPane.add(btnNovo, gbc_btnNovo);

		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				try {
					idAnimalEditar = (int) table.getModel().getValueAt(table.getSelectedRow(), 0);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(TelaPrincipal.this, "Selecione um registro para editar", "Atenção",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				Animal animalEditar = dao.getById(idAnimalEditar);

				txtEspecie.setText(animalEditar.getEspecie());
				txtNome.setText(animalEditar.getNome());
				txtProprietario.setText(animalEditar.getProprietario());

				animalSelecionado = animalEditar;

			}
		});
		GridBagConstraints gbc_btnEditar = new GridBagConstraints();
		gbc_btnEditar.insets = new Insets(0, 0, 0, 5);
		gbc_btnEditar.gridx = 3;
		gbc_btnEditar.gridy = 5;
		contentPane.add(btnEditar, gbc_btnEditar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int delete = 0;

				try {
					delete = (int) table.getModel().getValueAt(table.getSelectedRow(), 0);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(TelaPrincipal.this, "Selecione um registro para excluir!", "Atenção",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				Animal animalDelete = dao.getById(delete);

				dao.delete(animalDelete);

				JOptionPane.showMessageDialog(TelaPrincipal.this,
						"Animal " + animalDelete.getNome() + " removido com sucesso!!");

				updateTable();

			}
		});
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.gridx = 4;
		gbc_btnExcluir.gridy = 5;
		contentPane.add(btnExcluir, gbc_btnExcluir);

		try {

			dao = RemoteEJBClient.lookupRemoteStatelessCalculator();

		} catch (NamingException e) {
			e.printStackTrace();
		}

		updateTable();

	}

	protected void updateTable() {

		model = new AnimalModel(dao.getAll());
		table.setModel(model);
	}

	protected void limparCampos() {

		txtEspecie.setText("");
		txtNome.setText("");
		txtProprietario.setText("");

	}

	private void createUpdate() {
		if (animalSelecionado == null) {

			if (txtNome.getText().equals("") || txtEspecie.getText().equals("")) {
				JOptionPane.showMessageDialog(TelaPrincipal.this, "Preencha corretamente os campos");
			} else {

				Animal animal = new Animal();
				animal.setNome(txtNome.getText());
				animal.setProprietario(txtProprietario.getText());
				animal.setEspecie(txtEspecie.getText());

				dao.create(animal);
				limparCampos();

				limparCampos();

				updateTable();
			}
		} else {

			animalSelecionado.setId(idAnimalEditar);
			animalSelecionado.setNome(txtNome.getText());
			animalSelecionado.setEspecie(txtEspecie.getText());
			animalSelecionado.setProprietario(txtProprietario.getText());

			dao.edit(animalSelecionado);

			animalSelecionado = null;

			limparCampos();

			updateTable();

		}
	}

}
