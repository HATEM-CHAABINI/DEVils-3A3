<?php

namespace BibliothequeBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Bibliotheque
 *
 * @ORM\Table(name="bibliotheque", indexes={@ORM\Index(name="id_livre", columns={"id_livre"}), @ORM\Index(name="username_responsable", columns={"username_responsable"})})
 * @ORM\Entity
 */
class Bibliotheque
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var string
     *
     * @ORM\Column(name="nom_bibliotheque", type="string", length=255, nullable=false)
     */
    private $nomBibliotheque;

    /**
     * @var \Livre
     *
     * @ORM\ManyToOne(targetEntity="Livre")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_livre", referencedColumnName="id")
     * })
     */
    private $idLivre;

    /**
     * @var \FosUser
     *
     * @ORM\ManyToOne(targetEntity="FosUser")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="username_responsable", referencedColumnName="username_canonical")
     * })
     */
    private $usernameResponsable;



    /**
     * Get id
     *
     * @return integer
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * Set nomBibliotheque
     *
     * @param string $nomBibliotheque
     *
     * @return Bibliotheque
     */
    public function setNomBibliotheque($nomBibliotheque)
    {
        $this->nomBibliotheque = $nomBibliotheque;

        return $this;
    }

    /**
     * Get nomBibliotheque
     *
     * @return string
     */
    public function getNomBibliotheque()
    {
        return $this->nomBibliotheque;
    }

    /**
     * Set idLivre
     *
     * @param \BibliothequeBundle\Entity\Livre $idLivre
     *
     * @return Bibliotheque
     */
    public function setIdLivre(\BibliothequeBundle\Entity\Livre $idLivre = null)
    {
        $this->idLivre = $idLivre;

        return $this;
    }

    /**
     * Get idLivre
     *
     * @return \BibliothequeBundle\Entity\Livre
     */
    public function getIdLivre()
    {
        return $this->idLivre;
    }

    /**
     * Set usernameResponsable
     *
     * @param \BibliothequeBundle\Entity\FosUser $usernameResponsable
     *
     * @return Bibliotheque
     */
    public function setUsernameResponsable(\BibliothequeBundle\Entity\FosUser $usernameResponsable = null)
    {
        $this->usernameResponsable = $usernameResponsable;

        return $this;
    }

    /**
     * Get usernameResponsable
     *
     * @return \BibliothequeBundle\Entity\FosUser
     */
    public function getUsernameResponsable()
    {
        return $this->usernameResponsable;
    }
}
