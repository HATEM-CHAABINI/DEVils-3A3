<?php

namespace BibliothequeBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * RatingLivre
 *
 * @ORM\Table(name="rating_livre", indexes={@ORM\Index(name="fkk_livre", columns={"id_livre"}), @ORM\Index(name="fkk_user", columns={"username_locateur"})})
 * @ORM\Entity
 */
class RatingLivre
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
     * @var float
     *
     * @ORM\Column(name="note", type="float", precision=10, scale=0, nullable=false)
     */
    private $note;

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
     *   @ORM\JoinColumn(name="username_locateur", referencedColumnName="username_canonical")
     * })
     */
    private $usernameLocateur;



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
     * Set note
     *
     * @param float $note
     *
     * @return RatingLivre
     */
    public function setNote($note)
    {
        $this->note = $note;

        return $this;
    }

    /**
     * Get note
     *
     * @return float
     */
    public function getNote()
    {
        return $this->note;
    }

    /**
     * Set idLivre
     *
     * @param \BibliothequeBundle\Entity\Livre $idLivre
     *
     * @return RatingLivre
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
     * Set usernameLocateur
     *
     * @param \BibliothequeBundle\Entity\FosUser $usernameLocateur
     *
     * @return RatingLivre
     */
    public function setUsernameLocateur(\BibliothequeBundle\Entity\FosUser $usernameLocateur = null)
    {
        $this->usernameLocateur = $usernameLocateur;

        return $this;
    }

    /**
     * Get usernameLocateur
     *
     * @return \BibliothequeBundle\Entity\FosUser
     */
    public function getUsernameLocateur()
    {
        return $this->usernameLocateur;
    }
}
